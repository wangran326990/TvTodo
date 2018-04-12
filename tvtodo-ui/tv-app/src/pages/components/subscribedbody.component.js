/**
 * Created by wr on 30/03/18.
 */
/**
 * Created by wr on 30/03/18.
 */
import React from 'react';
import {Show} from './show.component';
import PropTypes from 'prop-types';
import {Row, Col} from 'react-flexbox-grid';


export class SubScribedBody extends React.Component {

    constructor(props){
        super(props);
    }

    render(){
        const {subscribedShowList} = this.props;
        return(
            <div>
                <Row id="subscribe-body-title">
                    <Col xs={12}>
                        <Row center="xs">
                            <Col xs={4} >
                                <h1>SubScripted Shows</h1>
                            </Col>
                        </Row>
                    </Col>
                </Row>
                <div id="subscribed-show-list">
                    <Row className="show-list-top">
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                        <Col xs={6} sm={4} md={2} lg={2}>
                            <Show show={{}}/>
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}


SubScribedBody.propTypes ={
    subscribedShowList: PropTypes.array.isRequired,
}
