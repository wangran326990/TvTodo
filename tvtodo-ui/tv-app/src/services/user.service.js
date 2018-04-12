/**
 * Created by wr on 20/03/18.
 */
import Rx from 'rxjs/Rx';
import {user_api} from '../constants/tvtodo-app.constants';


// const responseObserver = {
//     next: res=> console.log('Observer got a next value: ' + res),
//     error: err => console.error('Observer got an error: ' + err),
//     complete: () => console.log('Observer got a complete notification')
// };

function createAjaxObservable(url,requestOptions){
    return Rx.Observable
        .from(fetch(url,requestOptions))
        .flatMap((res)=>{
            return Rx.Observable.from(res.json())
        });
}

function login(username, password){
    const data = new URLSearchParams();
    data.append('username', username);
    data.append('password', password);


    const requestOptions = {
        method: 'POST',
        body: data,
        mode:'cors'
    };

    return createAjaxObservable(user_api.USER_LOGIN_REQUEST_URL,requestOptions)
           .map(
                (response)=>{
                    // login successful if there's a jwt token in the response
                    if (response.response) {
                        // store user details and jwt token in local storage to keep user logged in between page refreshes
                        localStorage.setItem('user', JSON.stringify(response.response));
                    }else{

                        throw response;
                    }
                    return response;
                }
           );


}

function getUserById(id){
    const requestOptions ={
        method: 'GET',
        mode:'cors'
    }
    let url = user_api.GET_USER_BY_ID_URL+id;
    return createAjaxObservable(url,requestOptions);

}

function update(user){
    const requestOptions = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(user)
    };
    return createAjaxObservable(user_api.USER_UPDATE_REQUEST_URL, requestOptions);
}
function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

function register(user){
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify(user),
        mode:'cors'
    };
    return createAjaxObservable(user_api.USER_REGISTER_REQUEST_URL, requestOptions);
}

export const userService = {
    login:login,
    logout:logout,
    register:register,
    getUserById:getUserById,
    update:update
};