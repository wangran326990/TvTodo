/**
 * Created by wr on 20/03/18.
 */
import {userConstants} from '../constants';


//let user = JSON.parse(localStorage.getItem('user'));
let user =null;
const initialState = user ? { loggedIn: true, user, loggingIn:false, error:"" } : {loggedIn: false, user:null, loggingIn:false, error:""};

export function authentication(state = initialState, action){
    switch(action.type){
        case userConstants.LOGIN_REQUEST:
            return {
                loggedIn:false,
                loggingIn: true,
                user: action.loginInfo.response,
                error:action.loginInfo.errorMessage
            };
        case userConstants.LOGIN_SUCCESS:
            return {
                loggingIn:false,
                loggedIn: true,
                user: action.loginInfo.response,
                error:action.loginInfo.errorMessage
            };
        case userConstants.LOGIN_FAILURE: {
            return {
                loggingIn: false,
                loggedIn: false,
                user: action.loginInfo.user,
                error: action.loginInfo.errorMessage
            };
        }
        case userConstants.LOGOUT:
            return {
                loggingIn:false,
                loggedIn: false,
                user: null,
                error: action.loginInfo.errorMessage
            };
        default:
            return state
    }
}