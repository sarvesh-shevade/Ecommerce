import React,{Fragment,useEffect} from 'react'
import { CgMouse } from "react-icons/cg";
import "./Home.css";
import Product from "./Product.js";
import Metadata from '../layout/Metadata.js';
import { getProduct } from '../../actions/productAction.js';
import {useDispatch,useSelector} from "react-redux";

import Loader from "../layout/Loader/loader.js";
import { useAlert } from "react-alert";



const Home = () => {

  const alert = useAlert()

  const dispatch = useDispatch();
  const { loading,error,products,productsCount } = useSelector(
    (state) => state.products
  )
  useEffect(() => {

    if(error){
      return alert.error(error);
    }
    dispatch(getProduct());
  },[dispatch,error]);
  

  return (
    <Fragment>

    {loading ? <Loader/> : <Fragment>
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
        ))};
        </div>
    
    </Fragment>}

    </Fragment>


  )
}

export default Home;