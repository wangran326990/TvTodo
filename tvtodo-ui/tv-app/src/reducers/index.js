/**
 * Created by wr on 19/03/18.
 */

import {combineReducers} from 'redux';
import {loginForm} from './login.form.reducer';
import {authentication} from './authentication.reducer';
import {registerForm} from './register.form.reducer';
import {alert} from './alert.reducer';
import {registerFormResponse} from './register.form.response.reducer';
const rootReducer = combineReducers({
            loginFormInfo:loginForm,
            authentication:authentication,
            registerFormInfo:registerForm,
            alertInfo:alert,
            registerFormResponse:registerFormResponse
    });
export default rootReducer;