/**
 * Created by wr on 24/03/18.
 */
import {userConstants} from '../constants';
import {userService} from'../services';
import {history} from '../helpers';
export const userActions ={
    doLogin,
    doLoginFormInput,
    doRegisterFormInput,
    doRegister
};

//login form information
let loginFormInfo = {
    username:"",
    password:""
};

//registed form information
let registedFormInfo ={
    username:"",
    password:"",
    firstname:"",
    lastname:""
}


function doLogin(username, password){


    return dispatch=>{
        loginFormInfo.username="";
        loginFormInfo.password="";

        dispatch(request({response:{}, errorMessage:""}));

        const responseObserver = {
            next: res=> {
                dispatch(success(res));
                history.push('/');

            },
            error: err => {
                dispatch(failure(err));
            },
            complete: () => console.log('Observer got a complete notification')
        };
        userService.login(username, password).subscribe(responseObserver);
    };

    function request(loginInfo) { return { type: userConstants.LOGIN_REQUEST,  loginInfo} }
    function success(loginInfo) { return { type: userConstants.LOGIN_SUCCESS, loginInfo } }
    function failure(loginInfo) { return { type: userConstants.LOGIN_FAILURE, loginInfo } }

}

function doRegister(user){
    return dispatch=>{
        registerFormClear();
        dispatch(request({response:{}, errorMessage:""}));

        const responseObserver = {
            next: res=> {
                dispatch(success(res));

            },
            error: err => {
                dispatch(failure(err));
            },
            complete: () => console.log('Observer got a complete notification')
        };
        userService.register(user).subscribe(responseObserver);
    }

    function request(registerInfo) { return { type: userConstants.REGISTER_REQUEST,  registerInfo} }
    function success(registerInfo) { return { type: userConstants.REGISTER_SUCCESS, registerInfo } }
    function failure(registerInfo) { return { type: userConstants.REGISTER_FAILURE, registerInfo } }
}

function doLoginFormInput(name, value){


       registedFormInfo[name] = value;
        let info = {
            username:registedFormInfo.username,
            password:registedFormInfo.password,

        };
        return {
            type:userConstants.LOGIN_FORM_INPUT,
            loginFormInfo:info
        }

}

function doRegisterFormInput(name, value){
    registedFormInfo[name] = value;
    let info = {
        userName:registedFormInfo.username,
        password:registedFormInfo.password,
        firstName:registedFormInfo.firstname,
        lastName:registedFormInfo.lastname
    };
    return {
        type:userConstants.REGISTER_FORM_INPUT,
        registedFormInfo:info
    }
}

function registerFormClear(){
    registedFormInfo.username="";
    registedFormInfo.password="";
    registedFormInfo.firstname="";
    registedFormInfo.lastname="";
}