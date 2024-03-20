import React from 'react';
import {Link} from "react-router-dom";
import ReactStars from "react-rating-stars-component";



const Product = ({ product }) => {

    const options={
        edit:false,
        color:"rgba(20,20,20,0.1)",
        activeColor:"tomato",
        size:window.innerWidth < 600 ? 20 : 25,
        value:product.prod_rating,
        isHalf:(product.prod_rating%1<1)
    };

  return (
    <Link className='productCard'to={product.prod_id}>
        <img src={product.prod_image_url} alt={product.prod_Name} />
        <p>{product.prod_Name}</p>
        <div>
            <ReactStars{...options}/> <span> {product.prod_reviewsCount}</span>
        </div>
        <span>₹{product.prod_price}</span>
    </Link>

)
}

export default Product