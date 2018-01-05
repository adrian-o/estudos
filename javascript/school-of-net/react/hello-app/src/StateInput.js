import React, {Component} from 'react';

class StateInput extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: 'Adriano Ohana'
        }

        setTimeout(()=>{
            this.setState({
                name: 'Adriano'
            });
        }, 1000);
    }

    render() {
        console.log(this.state);
        return(
            <div>
                <input type="text" name="name" value={this.state.name}></input>
            </div>
        )
    }
}

export default StateInput;