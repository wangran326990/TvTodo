/**
 * Created by wr on 28/03/18.
 */
import React from 'react';
import { Route, Redirect } from 'react-router-dom';
export const LoginRoute = ({ component: Component, ...rest }) => {
    return (
        <Route {...rest} render={props => (
            localStorage.getItem('user')
                ? <Redirect to={{ pathname: '/login', state: { from: props.location } }} />
                :<Component {...props} />
        )} />)
};