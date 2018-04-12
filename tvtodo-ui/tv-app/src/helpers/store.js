/**
 * Created by wr on 19/03/18.
 */
import { createStore, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import rootReducer from '../reducers';


export const store = createStore(
    rootReducer,
    applyMiddleware(
        thunkMiddleware
    )
);