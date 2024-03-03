import React,{Fragment,useEffect} from 'react'
import { CgMouse } from "react-icons/cg";
import "./Home.css";
import Product from "./Product.js";
import Metadata from '../layout/Metadata.js';
import { getProduct } from '../../actions/productAction.js';
import {useDispatch,useSelector} from "react-redux";


const product ={
    name:"Iphone",
    price:"₹50000",
    image:[{url:"https://rukminim2.flixcart.com/image/416/416/xif0q/mobile/m/o/b/-original-imaghx9qkugtbfrn.jpeg?q=70&crop=false"}],
    _id: "01"
};

const Home = () => {

  const dispatch = useDispatch();
  const { loading,error,products,productsCount } = useSelector(
    (state) => state.products
  )
  useEffect(() => {
    dispatch(getProduct());
  },[dispatch]);
  

  return (
    <Fragment>
      <Metadata title="Ecommerce"/>

    <div className='banner'>
        <p> Welcome to DigiKart🛒 </p>
        <h1>Find Amazing Products Below </h1>

        <a href='#container'>
            <button>
                Scroll <CgMouse/>
            </button>
        </a>
        </div>

        <h2 className='homeHeading'>Featured Products</h2>
        <div className='container' id='container'>
        
        {products && products.map(product =>(
          <Product product={product}/>
        )
          

          )};
        </div>
    
    </Fragment>
  )
}

export default Home;