import React, {useEffect, useState} from 'react';
import './App.css';


const App: React.FC = () => {

    const [actors, setActors] = useState<ActorDto[]>()
    const [error, setError] = useState<string | undefined>()

    useEffect(() => {
        fetch("http://localhost:8080/actors")
            .then(res => res.json())
            .then(json => setActors(json as ActorDto[]))
            .catch(err => setError(err))
    }, [])

    return (
        <div className="App">
            {error && <div>ERROR: {error}</div>}
            {actors && actors.map(actor => {
                return <div>Actor {actor.firstName} {actor.lastName} </div>
            })}
        </div>
    );
}

export default App;
