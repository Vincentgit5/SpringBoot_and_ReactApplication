import React, { Component } from 'react';

class ListElements extends Component {
  constructor(props) {
    super(props);
    this.state = {
      table: [
        {
          id: 1,
          description: 'blue man',
          done: false,
          targetDate: new Date()
        },
        {
            id: 2,
            description: 'Good Doctor',
            done: true,
            targetDate: new Date()
          },
          {
            id: 3,
            description: 'Game of thrones',
            done: false,
            targetDate: new Date()
          }
      ]};
    }

  render() {
    return (
      <div>
        <h1>List of elements</h1>
        <div className='container'>
          <table className='table'>
            <thead>
              <tr>
                <th>id</th>
                <th>Description</th>
                <th>Is completed</th>
                <th>Target date </th>
              </tr>
            </thead>
            <tbody>
              {this.state.table.map((item, index) => (
                <tr key={index}>
                  <td>{item.id}</td>
                  <td>{item.description}</td>
                  <td>{item.done.toString()}</td>
                  <td>{item.targetDate.toString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListElements;