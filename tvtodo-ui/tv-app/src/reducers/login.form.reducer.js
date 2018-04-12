/**
 * Created by wr on 25/03/18.
 */
import {userConstants} from '../constants';

export function loginForm(state = {
                            username:"",
                            password:"",
}, action) {

    switch (action.type) {
        case userConstants.LOGIN_FORM_INPUT: {
            return action.loginFormInfo;
        }
        // case userConstants.LOGIN_REQUEST:{
        //     return{
        //         username:"",
        //         password:""
        //     }
        // }
        case userConstants.LOGIN_FAILURE:{
            return {
                username:"",
                password:""
            };
        }
        default:
            return state;
    }
}