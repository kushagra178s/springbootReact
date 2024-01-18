import Axios from "axios";
import "./App.css";
import { useEffect, useRef, useState } from "react";

export default function App() {
  const updateFormref = useRef(null);
  const formref = useRef(null);
  const [data, setData] = useState([]);
  function fetchData() {
    Axios.get("http://localhost:8989/courses")
      .then((response) => {
        // Assuming the response.data contains the array of courses
        setData(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }
  function updateData(e) {
    e.preventDefault();
    const newdata = {
      id: formref.current.id.value,
      title: formref.current.title.value,
      description: formref.current.description.value,
      value: formref.current.value.value,
    };
    Axios.post("http://localhost:8989/courses", newdata).then((status) =>
      console.log(status)
    );
  }

  function deleteData(e) {
    e.preventDefault();
    const id = updateFormref.current.courseid.value;
    console.log(data);
    Axios.delete(`http://localhost:8989/courses/${id}`).then((status) =>
      console.log(status)
    );
  }
  useEffect(() => {
    fetchData();
  }, []);
  return (
    <div className="container">
      <div className="fetch">
        <h1>
          <u>
            this application is designed to connect reactjs based frontend to
            java spring boot based backend with mysql database.
          </u>
        </h1>
        <h1>
          <u>data fetched:</u>
        </h1>
        <button onClick={fetchData}>update data</button>
        <div className="show-data">
          {data &&
            data.map((item) => {
              return (
                <div className="data-card" key={item.id}>
                  <h2>{item.id}</h2>
                  <h2>{item.title}</h2>
                  <h2>{item.description}</h2>
                  <h2>{item.value}</h2>
                </div>
              );
            })}
        </div>
      </div>
      <div className="crud">
        <h1>
          <u>crud:</u>
        </h1>
        <hr />
        <h2>enter some details for course:</h2>
        <form ref={formref} onSubmit={updateData}>
          <label>
            CourseId : <input type="text" name="id" />
          </label>
          <br />
          <br />
          <label>
            title : <input type="text" name="title" />
          </label>
          <br />
          <br />
          <label>
            description : <input type="text" name="description" />
          </label>
          <br />
          <br />
          <label>
            value : <input type="text" name="value" />
          </label>
          <br />
          <br />
          <button type="submit">click</button>
        </form>
        <hr />
        <h2>enter id of course:</h2>
        <form ref={updateFormref} onSubmit={deleteData}>
          <label htmlFor="courseid">
            Course : <input type="text" name="courseid" />{" "}
          </label>
          <br />
          <br />
          <button type="submit">delete</button>
        </form>
        {/* <hr /> */}
      </div>
    </div>
  );
}
