import axios from "axios";
import {
    ALL_PRODUCT_FAIL,
    ALL_PRODUCT_SUCCESS,
    ALL_PRODUCT_REQUEST,
    CLEAR_ERRORS
    } from "../constants/prodConstants"


export const getProduct = () => async (dispatch) => {

    try{

        dispatch({type:ALL_PRODUCT_REQUEST});
        const {data}  = await axios.get("http://localhost:8080/home/getList");
        
        dispatch({
            type:ALL_PRODUCT_SUCCESS,
            payload:data,
        });
    }
    catch(error)
    {
        dispatch({
            type:ALL_PRODUCT_FAIL,
            payload:error.response.data.message,
        });
    }
};

//clearing errors
export const clearErrors = () => (dispatch) => {
    dispatch({type:CLEAR_ERRORS});
}

