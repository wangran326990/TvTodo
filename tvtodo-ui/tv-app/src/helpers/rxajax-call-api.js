/**
 * Created by wr on 20/03/18.
 */
import Rx from 'rxjs/Rx';
import helpers from './helpers';

export const rxJsAjax ={
    getAsync:getAsync,
    postAsync:postAsync
}

function getAsync(url){

    return Rx.Observable.create(function(observer){
            var req = new XMLHttpRequest();
            req.open('GET',url);
            req.onload = function(){
                if(req.status == 200){
                    observer.next(req.response);
                }else{
                    observer.error(new Error(req.statusText));
                }
            };
            req.onerror = function(){
                observer.error(new Error(req.statusText));
            };
            req.send();
    })
}


function postAsync(url,params){

    return Rx.Observable.create(function(observer){
        var req = new XMLHttpRequest();
        var jsonParams = {};
        if(params != null && helpers.isJson(params)){
            jsonParams =   JSON.stringify(params);
        }else if(params!=''){
            jsonParams = params;
        }else{
            jsonParams = {};
        }

        req.open('POST',url);
        req.onload = function(){
            if(req.status == 200){
                observer.next(req.response);
            }else{
                observer.error(new Error(req.statusText));
            }
        };
        req.onerror = function(){
            observer.error(new Error(req.statusText));
        };
        req.send();
    })
}