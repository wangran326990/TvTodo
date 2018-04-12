/**
 * Created by wr on 28/03/18.
 */
import {userConstants} from '../constants';
export function registerForm(state={userName:"", password:"", firstName:"", lastName:""}, action){
    switch(action.type){

        case userConstants.REGISTER_FORM_INPUT:
            return action.registedFormInfo;
        case userConstants.REGISTER_REQUEST:
            return {
                userName:"",
                password:"",
                firstName:"",
                lastName:""
            };
        default:
            return state;
    }
}