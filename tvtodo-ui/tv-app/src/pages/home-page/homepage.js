/**
 * Created by wr on 27/03/18.
 */
import React from 'react';
import AppBar from 'material-ui/AppBar';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MenuIcon from 'material-ui/svg-icons/navigation/menu'
import MoreVertIcon from 'material-ui/svg-icons/navigation/more-vert';
import MenuItem from 'material-ui/MenuItem';
import Drawer from 'material-ui/Drawer';
import '../../css/homepage.css';
import Divider from 'material-ui/Divider';
import {PrivateRoute,LoginRoute} from'../../router';
//import SearchBody from './components/searchbody.component';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';
import {SubScribedBody,SearchBody}from'../components';
import{Route} from 'react-router-dom';

export class HomePage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {open: false, path:window.location.pathname};
        this.handleToggle = this.handleToggle.bind(this);
        this.handleRouteInHomepage = this.handleRouteInHomepage.bind(this);
        this.renderHomepageBody = this.renderHomepageBody.bind(this);
    }

    handleRouteInHomepage(path) {
        window.history.pushState(null,'',path);
        this.setState({path: path});
    }
    renderHomepageBody(path){
            switch(path) {
                case '/':
                    return (<SearchBody />);
                case '/subscribes':
                    return (<SubScribedBody />);

                default:
                    return "PAGE NOT FOUND";
            }

    }

    handleToggle = () => this.setState({open: !this.state.open});


    render(){
        const contentStyle = {  transition: 'margin-left 450ms cubic-bezier(0.23, 1, 0.32, 1)' };

        const style ={
            color: 'rgb(0, 188, 212)',
            fontFamily: "'Lobster', cursive"
        };

        if (this.state.open) {
            contentStyle.marginLeft = 256;
        }

        return (
            <MuiThemeProvider>
                <div>
                <Drawer
                    open={this.state.open}>
                    <AppBar title="TvTodo App" iconElementLeft={(
                        <div />
                    )}/>
                    <Divider />
                    <MenuItem className="menu-text"
                              primaryText="Home"
                              innerDivStyle={style}
                              onClick={
                                  ()=>{
                                      this.handleRouteInHomepage('/');
                                  }
                              }
                    />

                    <MenuItem className="menu-text"
                              primaryText="My Subscription"
                              innerDivStyle={style}
                              onClick={
                                  ()=>{
                                      this.handleRouteInHomepage('/subscribes');
                                  }
                              }
                    />
                </Drawer>
                    <div id="container" style={contentStyle}>
                    <div id="header">
                        <AppBar
                            id="login-appbar"
                            title="TvTodo"
                            iconElementLeft={(
                                <IconButton><MenuIcon onClick={this.handleToggle}/></IconButton>
                            )}
                            iconElementRight={( <IconMenu
                                iconButtonElement={
                                    <IconButton><MoreVertIcon /></IconButton>
                                }
                                targetOrigin={{horizontal: 'right', vertical: 'top'}}
                                anchorOrigin={{horizontal: 'right', vertical: 'top'}}
                            >
                                <MenuItem  primaryText="Edit" />
                                <MenuItem  primaryText="Sign out" />
                            </IconMenu>)}
                        />
                    </div>


                    <div id="body">
                        {this.renderHomepageBody(this.state.path)}
                    </div>

                </div>
                </div>
            </MuiThemeProvider>
        )
    }
}

// HomePage.propTypes ={
//     homepageBody: PropTypes.object.isRequired,
// };