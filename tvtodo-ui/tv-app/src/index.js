/**
 * Created by wr on 19/03/18.
 */
import React from 'react';
import ReactDOM from 'react-dom';
import {App} from './app/App';
import {Provider} from 'react-redux';
import { store } from './helpers';
ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementById('root')
);