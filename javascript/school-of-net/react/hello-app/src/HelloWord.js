import React, {Component} from 'react';

import StateInput from './StateInput';

class HelloWorld extends Component {
    
    constructor(props) {
        super(props)
        this.state = {
            name: 'Adriano Ohana'
        }
    }

    render() { 
        const result = 4;
        const style = {
            color: '#FFFF00',
            fontSize: 50,
            backgroundColor: '#000000'
        };

        return(
            <div className="my-class-from-react">
                <StateInput />
                <h1 style={style}>Starting with React.JS</h1>
                <h4>{result === 2*2 ? 'TRUE' : 'FALSE'}</h4>
                <span>{this.state.name}</span>
            </div>
        )
    }
}

export default HelloWorld;