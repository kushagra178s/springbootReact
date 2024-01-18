import React from "react";
const ProductCard = (props) => {
  console.log(props.props);
  return (
    <div style={{maxHeight:"200px"}} >
      <img style={{width:"250px", height:"150px"}} src={props.props.images[0]} alt={props.props.title}  />
      <div >
        <h2 >{props.props.title}</h2>
        <p>{props.props.description}</p>
        <p>Brand: {props.props.brand}</p>
        <p>Category: {props.props.category}</p>
        <p>Price: ${props.props.price}</p>
        <p>Rating: {props.props.rating}</p>
        <p>Stock: {props.props.stock}</p>
        <p>Discount: {props.props.discountPercentage}%</p>
      </div>
    </div>
  );
};

export default ProductCard ;