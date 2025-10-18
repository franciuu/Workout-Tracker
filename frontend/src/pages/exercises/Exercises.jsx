import "./Exercises.css"
import SearchBar from "../../components/SearchBar/SearchBar"
import ExerciseCard from "../../components/ExerciseCard/ExerciseCard"
import { fetchExercises } from "../../services/ExercisesService"
import { useEffect, useState } from "react"

const Exercises = () => {
    const [exercises, setExercises] = useState([]);
    const [filters, setFilters] = useState({});

    const getExercises = async () => {
        try {
            const response = await fetchExercises(filters);
            setExercises(response.data);
        } catch(error) {
            console.log(error);
        }
    }
    useEffect(() => {
        getExercises();
    }, [filters]);

    return (
        <div className="exercises-page">
            <div className="exercises-container">
                <div className="exercises-header mb-4">
                    <div>
                        <h1 className="exercises-title">Exercise Library</h1>
                        <p className="exercises-subtitle">Browse and discover exercises for your workouts</p>
                    </div>
                </div>

            <div className="d-flex flex-column flex-md-row gap-3 mb-4 align-items-start align-items-md-center">
                <div className="flex-grow-1 w-100">
                    <SearchBar />
                </div>
                <div className="dropdown">
                    <button 
                        className="btn btn-outline-secondary dropdown-toggle filter-dropdown-btn" 
                        type="button" 
                        id="filterDropdown" 
                        data-bs-toggle="dropdown" 
                        aria-expanded="false"
                    >
                        <svg 
                            xmlns="http://www.w3.org/2000/svg" 
                            width="16" 
                            height="16" 
                            viewBox="0 0 24 24" 
                            fill="none" 
                            stroke="currentColor" 
                            strokeWidth="2" 
                            strokeLinecap="round" 
                            strokeLinejoin="round"
                            className="me-2"
                        >
                            <polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" />
                        </svg>
                        Filter
                    </button>
                    <ul className="dropdown-menu dropdown-menu-end filter-dropdown-menu" aria-labelledby="filterDropdown">
                        <li><a className="dropdown-item" href="#">All Levels</a></li>
                        <li><hr className="dropdown-divider" /></li>
                        <li><a className="dropdown-item" href="#">Beginner</a></li>
                        <li><a className="dropdown-item" href="#">Intermediate</a></li>
                        <li><a className="dropdown-item" href="#">Advanced</a></li>
                    </ul>
                </div>
            </div>

            {exercises && exercises.length > 0 ? (
                <div className="exercise-grid">
                    {exercises.map((exercise) => (
                        <ExerciseCard key={exercise.exerciseId} exercise={exercise}/>
                    ))}
                </div>
            ) : (
                <div className="no-exercises-container text-center py-5">
                    <svg 
                        xmlns="http://www.w3.org/2000/svg" 
                        width="48" 
                        height="48" 
                        viewBox="0 0 24 24" 
                        fill="none" 
                        stroke="currentColor" 
                        strokeWidth="2" 
                        strokeLinecap="round" 
                        strokeLinejoin="round"
                        className="no-exercises-icon mx-auto mb-3"
                    >
                        <polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" />
                    </svg>
                    <h3 className="no-exercises-title">No exercises found</h3>
                    <p className="no-exercises-text">Try adjusting your search or filters</p>
                </div>
            )}
            </div>
        </div>
    )
}

export default Exercises