/**
 * Created by wr on 29/03/18.
 */
/**
 * Created by wr on 28/03/18.
 */
import {userConstants} from '../constants';
export function registerFormResponse(state={response:"", errorMessage:""}, action){
    switch(action.type){

        case userConstants.REGISTER_REQUEST:
            return action.registerInfo;
        case userConstants.REGISTER_SUCCESS:
            return action.registerInfo;
        case userConstants.DELETE_FAILURE:
            return action.registerInfo;
        default:
            return state;
    }
}