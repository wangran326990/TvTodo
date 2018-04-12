/**
 * Created by wr on 24/03/18.
 */
import { alertConstants } from '../constants';
import {validationHelpers} from '../helpers';

export const alertActions ={
    registerFormValidation,
};
let registeredFormError ={
    username:"",
    password:"",
    firstname:"",
    lastname:""
}


function registerFormValidation(name, value, rules){
    let result = validationHelpers.formValidation(value, rules);
    registeredFormError[name] = result;
    let info = {
        username:registeredFormError.username,
        password:registeredFormError.password,
        firstname:registeredFormError.firstname,
        lastname:registeredFormError.lastname
    };
    if(result===""){
        return { type: alertConstants.SUCCESS,  info};
    }
    return {type: alertConstants.ERROR, info};
}