import {
    ALL_PRODUCT_FAIL,
    ALL_PRODUCT_SUCCESS,
    ALL_PRODUCT_REQUEST,
    CLEAR_ERRORS
    } from "../constants/prodConstants"



 export const productReducer = (state = { products:[] },action) => {

    switch (action.type) {
        case ALL_PRODUCT_REQUEST:
            return{
                loading:true,
                product:[],
            };
            
        case ALL_PRODUCT_SUCCESS:
            return {
                loading:false,
                products:action.payload.products,
                prodcutsCount:action.payload.prodcutsCount,
            };

        case ALL_PRODUCT_FAIL:
            return {
                loading:false,
                error:action.payload.products,
            };

        case CLEAR_ERRORS:
            return {
                ...state,
                error:null,
            };
        
        default:
            return state;
            
    }
};
