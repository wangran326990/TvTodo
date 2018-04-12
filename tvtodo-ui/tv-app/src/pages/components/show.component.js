/**
 * Created by wr on 30/03/18.
 */
import React from 'react';
import {Card, CardActions, CardMedia} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import PropTypes from 'prop-types';
import {Row, Col} from 'react-flexbox-grid';
export class Show extends React.Component {

        constructor(props){
            super(props);
        }

        render(){
            const {show} = this.props;
            return(
                <div className="card-top">
                <Card>

                    <CardMedia
                    >
                        <img src="http://static.tvmaze.com/uploads/images/medium_portrait/31/78286.jpg" alt=""/>
                    </CardMedia>
                    <CardActions>
                        <Row>
                            <Col>
                                <FlatButton label="Subscribe" />
                            </Col>
                        </Row>
                    </CardActions>
                </Card>
                </div>
            )
        }
}

Show.propTypes ={
    show: PropTypes.object.isRequired,
}

