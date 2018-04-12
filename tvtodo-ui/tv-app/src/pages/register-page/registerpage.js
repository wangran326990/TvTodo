/**
 * Created by wr on 27/03/18.
 */
import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import {Row, Col} from 'react-flexbox-grid';
import '../../css/register-page.css';
import FlatButton from 'material-ui/FlatButton';
import {Link} from 'react-router-dom';
import {userActions}from '../../actions';
import {alertActions} from '../../actions';
import {connect} from 'react-redux';

class RegisterPage extends React.Component {

    constructor(props){
        super(props);
        this.enableSubmit = this.enableSubmit.bind(this);
    }

    componentWillMount(){
        this.props.registerFormResponse.response = null;
    }

    enableSubmit(errorMessage, formInfo){
        for(let key in errorMessage){
            if(errorMessage.hasOwnProperty(key)){
                if(errorMessage[key]!==""){
                    return false;
                }
            }
        }

        for(let key in formInfo){
            if(formInfo.hasOwnProperty(key)){
                if(formInfo[key]===""){
                    return false;
                }
            }
        }


        return true;
    }

    render() {
        let isSubmitButtonEnabled = this.enableSubmit(this.props.alertInfo, this.props.registerFormInfo);

        return (
            <MuiThemeProvider>
                <div>
                    <AppBar
                        id="register-appbar"
                        title="TvTodo"
                        iconElementLeft={(<div />)}
                        iconElementRight={<FlatButton label="LOGIN" containerElement={<Link to="/login" />}/>}
                    />
                    <h1 id="page-title">Register</h1>
                    <form id="register-form" >
                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        <TextField
                                            name="firstname"
                                            value={this.props.registerFormInfo.firstName}
                                            hintText="Enter your First Name"
                                            floatingLabelText="First Name"
                                            errorText={this.props.alertInfo.firstname}
                                            onChange={
                                                (e)=> {
                                                    let rules=[
                                                        {
                                                            regx:/([^\s])/,
                                                            errorMessage:"first name required"
                                                        }
                                                    ];
                                                    this.props.onChangeHandler(e, rules);
                                                    this.props.registerFormResponse.response=null;
                                                }
                                            }
                                        />
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        <TextField
                                            name="lastname"
                                            value={this.props.registerFormInfo.lastName}
                                            hintText="Enter your Last Name"
                                            floatingLabelText="Last Name"
                                            errorText={this.props.alertInfo.lastname}
                                            onChange={
                                                (e)=> {
                                                    let rules=[
                                                        {
                                                            regx:/([^\s])/,
                                                            errorMessage:"last name required"
                                                        }
                                                    ];
                                                    this.props.onChangeHandler(e, rules);
                                                    this.props.registerFormResponse.response=null;
                                                }
                                            }
                                        />
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        <TextField
                                            name="username"
                                            value={this.props.registerFormInfo.userName}
                                            hintText="Enter your UserName"
                                            floatingLabelText="UserName"
                                            errorText={this.props.alertInfo.username}
                                            onChange={
                                                (e)=> {
                                                    let rules=[
                                                        {
                                                            regx:/([^\s])/,
                                                            errorMessage:"username required"
                                                        }
                                                    ];
                                                    this.props.onChangeHandler(e, rules);
                                                    this.props.registerFormResponse.response=null;
                                                }
                                            }
                                        />
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        <TextField
                                            type = "password"
                                            hintText="Enter your Password"
                                            floatingLabelText="Password"
                                            errorText={this.props.alertInfo.password}
                                            name="password"
                                            value={this.props.registerFormInfo.password}
                                            onChange={
                                                (e)=> {
                                                    let rules=[
                                                        {
                                                            regx:/([^\s])/,
                                                            errorMessage:"password required"
                                                        }
                                                    ];
                                                    this.props.onChangeHandler(e, rules);
                                                    this.props.registerFormResponse.response=null;
                                                }
                                            }
                                        />
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        <RaisedButton label="Submit" primary={true} disabled={!isSubmitButtonEnabled} onClick={()=>{
                                            this.props.onClickHandler(this.props.registerFormInfo);
                                        }}
                                        />
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        {(this.props.registerFormResponse.response!=="successful" && this.props.registerFormResponse.response!==null) && <p id="error-message">{this.props.registerFormResponse.errorMessage}</p>}
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                        <Row>
                            <Col xs={12}>
                                <Row center="xs">
                                    <Col xs={6}>
                                        {(this.props.registerFormResponse.response==="successful") && <p id="successful-message">{this.props.registerFormResponse.response}</p>}
                                    </Col>
                                </Row>
                            </Col>
                        </Row>

                    </form>
                </div>
            </MuiThemeProvider>
        );
    }
}


function matchDispatchToProps(dispatch){
    return {
        onChangeHandler:(event, rules) =>{
            let {name, value} = event.target;
            dispatch(userActions.doRegisterFormInput(name, value));
            dispatch(alertActions.registerFormValidation(name, value,rules));
        },
        onClickHandler:(user) =>{
            console.log(user);
            dispatch(userActions.doRegister(user));
        }
    }
}

function mapStateToProps(state){
    return {
        registerFormInfo:state.registerFormInfo,
        alertInfo:state.alertInfo,
        registerFormResponse:state.registerFormResponse
    };
}

const connectedRegisterPage= connect(mapStateToProps,matchDispatchToProps)(RegisterPage);

export {connectedRegisterPage as RegisterPage};