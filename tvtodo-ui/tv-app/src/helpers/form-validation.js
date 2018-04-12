/**
 * Created by wr on 28/03/18.
 */


const formValidation =(value, rules=[])=>{
    if(value==null){
        return"";
    }
    for(let i=0; i<rules.length;i++){
        if(!rules[i].regx.test(value)){
            return rules[i].errorMessage;
        }
    }
    return "";
}

export const validationHelpers = {
    formValidation,
}
