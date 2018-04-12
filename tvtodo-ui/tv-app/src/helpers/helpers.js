/**
 * Created by wr on 20/03/18.
 */
var helpers = (function(){

    function isJson(jsonString){
        try {
            JSON.parse(jsonString);
        } catch (e) {
            return false;
        }
        return true;
    }

    return {
        isJson: isJson
    }
})();
export default helpers;