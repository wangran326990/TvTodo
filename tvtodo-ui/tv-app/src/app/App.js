/**
 * Created by wr on 27/03/18.
 */
import React from 'react';
import{Route, Router} from 'react-router-dom';
import {history} from '../helpers';
import {PrivateRoute,LoginRoute} from'../router';
import {RegisterPage} from '../pages/register-page';
import {LoginPage} from '../pages/login-page';
import {HomePage} from'../pages/home-page';

export class App extends React.Component {
    render(){
      return (  <Router history={history}>
                    <div>

                        <LoginRoute  path="/login" component={LoginPage} />

                        <PrivateRoute exact path="/" component={HomePage} />

                        <Route exact path="/register" component={RegisterPage} />

                        <PrivateRoute path="/subscribes" component={HomePage} />

                    </div>
                </Router>)
    }
}
