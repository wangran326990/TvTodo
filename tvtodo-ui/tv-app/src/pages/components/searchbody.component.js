/**
 * Created by wr on 29/03/18.
 */

/*
 <Row id="search-country-title-bar">
 <Col xs={12}>
 <Row center="xs">
 <Col xs={4} >
 <div className="left search-bar-title"> Select Country: </div>
 </Col>
 </Row>

 <Row center="xs">
 <Col xs={4} >
 <SearchBar
 onChange={() => console.log('onChange')}
 onRequestSearch={() => console.log('onRequestSearch')}
 />
 </Col>
 </Row>
 </Col>
 </Row>

 <Row id="search-country-title-bar">
 <Col xs={12}>

 <Row center="xs">
 <Col xs={4} >
 <div className="left search-bar-title"> Select Country: </div>
 </Col>
 </Row>

 <Row center="xs">
 DatePicker
 </Row>
 </Col>
 </Row>
 */
import React from 'react';
import SearchBar from 'material-ui-search-bar';
import {Row, Col} from 'react-flexbox-grid';
import RaisedButton from 'material-ui/RaisedButton';
import {Show} from './show.component';
import PropTypes from 'prop-types';

export class SearchBody extends React.Component {
    constructor(props){
        super(props);
        this.state ={
            searchBarHide:true
        };
    }

    render(){
        //const {showlist} =this.props;
        return(

            <div>
                <div>
                    <Row id="search-show-title-bar">
                        <Col xs={12}>
                            <Row center="xs">
                                <Col xs={4} >
                                    <div className="left search-bar-title"> Show Tile: </div>
                                </Col>
                            </Row>

                            <Row center="xs">
                                <Col xs={4} >
                                    <SearchBar
                                        onChange={() => console.log('onChange')}
                                        onRequestSearch={() => console.log('onRequestSearch')}
                                    />
                                </Col>
                            </Row>
                        </Col>
                    </Row>

                </div>

                <Row id="search-button-row">
                    <Col xs={12}>
                        <Row  center="xs">
                            <Col xs={6}>
                                <RaisedButton label="New Shows Search" primary={true} />
                            </Col>
                        </Row>
                    </Col>
                </Row>
                <div id="search-result">
                    <Row around="xs" className="show-list-top">
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>

                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>

                        <Col xs={1} >
                            <Show show={{}}/>
                        </Col>
                    </Row>
                </div>

            </div>

        )
    }
}

