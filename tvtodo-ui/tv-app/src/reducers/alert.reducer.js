/**
 * Created by wr on 24/03/18.
 */
import {alertConstants} from '../constants';
export function alert(state={}, action){
    switch (action.type){
        case alertConstants.SUCCESS:
            return action.info;
        case alertConstants.ERROR:
            return action.info;
        case alertConstants.CLEAR:
            return{};
        default:
            return state;
    }
}