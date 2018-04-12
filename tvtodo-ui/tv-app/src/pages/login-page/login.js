/**
 * Created by wr on 19/03/18.
 */

import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import {Row, Col} from 'react-flexbox-grid';
import '../../css/login-page.css';
import {userActions} from '../../actions';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';
import FlatButton from 'material-ui/FlatButton';



class Login extends React.Component {
    constructor(props){
        super(props);

    }

    componentWillMount(){
        this.props.authentication.error=null;
    }
    //
    // handleChange(e) {
    //     const { name, value } = e.target;
    //     this.setState({ [name]: value });
    // }
    //
    // handleSubmit(e) {
    //     e.preventDefault();
    //
    //     this.setState({ submitted: true });
    //     const { username, password } = this.state;
    //     const { dispatch } = this.props;
    //     if (username && password) {
    //         console.log("do login");
    //         dispatch(userActions.doLogin(username, password));
    //     }
    // }

    render(){
        return (
                <MuiThemeProvider>
                    <div>
                        <AppBar
                            id="login-appbar"
                            title="TvTodo"
                            iconElementLeft={(<div />)}
                            iconElementRight={<FlatButton label="REGISTER" containerElement={<Link to="/register" />}/>}
                        />
                        <h1 id="page-title">Login</h1>
                        <form id="login-form" >
                            <Row>
                                <Col xs={12}>
                                    <Row center="xs">
                                        <Col xs={6}>
                                            <TextField
                                                name="username"
                                                onChange={
                                                    (e)=> {
                                                        this.props.authentication.error=null;
                                                        this.props.onChangeHandler(e);
                                                    }
                                                }
                                                value={this.props.loginFormInfo.username}
                                                hintText="Enter your Username"
                                                floatingLabelText="Username"
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
                                                type="password"
                                                name="password"
                                                onChange={
                                                    (e)=> {
                                                        this.props.authentication.error=null;
                                                        this.props.onChangeHandler(e);
                                                    }
                                                }
                                                value={this.props.loginFormInfo.password}
                                                hintText="Enter your Password"
                                                floatingLabelText="Password"
                                            />
                                        </Col>

                                    </Row>
                                </Col>
                            </Row>

                            <Row>
                                <Col xs={12}>
                                    <Row center="xs">
                                        <Col xs={6}>
                                            <RaisedButton label="Submit" primary={true} onClick={()=>{
                                                this.props.onClickHandler(this.props.loginFormInfo.username,this.props.loginFormInfo.password);

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
                                                {this.props.authentication.error && <p id="error-message">{this.props.authentication.error}</p>}
                                        </Col>
                                    </Row>
                                </Col>
                            </Row>

                        </form>
                    </div>
                </MuiThemeProvider>
        )
    }
}
function matchDispatchToProps(dispatch){
        return {
            onChangeHandler:(event) =>{
                let {name, value} = event.target;
                dispatch(userActions.doLoginFormInput(name, value));
            },
            onClickHandler:(username, password) =>{
                dispatch(userActions.doLogin(username, password));
            }
        }
}

function mapStateToProps(state){
    const{loggingIn} = state.authentication;
    return {
        loginFormInfo:state.loginFormInfo,
        loggingIn:loggingIn,
        authentication:state.authentication
    };
}
const connectedLoginPage = connect(mapStateToProps,matchDispatchToProps)(Login);
export { connectedLoginPage as LoginPage };