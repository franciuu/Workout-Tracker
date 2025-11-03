import "./CreateRoutine.css"
import ExercisesList from "../../components/exercisesList/ExercisesList.jsx"
import { useNavigate } from "react-router-dom";
import {useState, useEffect} from "react";
import { fetchExercises } from "../../services/ExercisesService"
import { createRoutine } from "../../services/RoutineService";

const CreateRoutine = () => {
    const [availableExercises, setAvailableExercises] = useState([]);
    const [filters, setFilters] = useState({});
    const [selectedExercises, setSelectedExercises] = useState([]);
    const [formData, setFormData] = useState({name: "", exercises: [], userId: ""});

    const navigate = useNavigate();

    const getExercises = async () => {
        try {
            const response = await fetchExercises(filters);
            setAvailableExercises(response.data);
        } catch(error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getExercises();
    }, [filters]);

    useEffect(() => {
        const exercises = selectedExercises.map((exercise, index) => ({
            exerciseId: exercise.exerciseId,
            sets: exercise.sets,
            reps: exercise.reps,
            weight: exercise.weight,
            orderIndex: index
        }));
        setFormData({...formData, exercises});
    }, [selectedExercises])

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("Submitting routine:", formData);
    }

    return (
        <div className="create-routine-page">
            <div className="create-routine-container">
                <div className="create-routine-header">
                    <button className="back-button" onClick={() => navigate("/routines")}>
                        <i class="bi bi-arrow-left"></i>
                        Back to Routines
                    </button>
                    <h1 className="create-routine-title">Create Routine</h1>
                </div>

                <form className="create-routine-form" onSubmit={handleSubmit}>
                    <div className="form-card">
                        <div className="form-card-body">
                            <div className="form-group">
                                <label htmlFor="routine-name" className="form-label">Routine Name</label>
                                <input 
                                    id="routine-name" 
                                    name="routine-name" 
                                    type="text" 
                                    className="form-input"
                                    value={formData.name}
                                    onChange={(e) => {setFormData(prev => ({...prev, name: e.target.value}))}}
                                    placeholder="e.g., Upper Body Strength"
                                />
                            </div>
                        </div>
                    </div>

                    <div className="exercises-section">
                        <ExercisesList exercises={availableExercises} 
                                    onSearchChange={(name) => setFilters({...filters, name})} 
                                    selectedExercises={selectedExercises}
                                    setSelectedExercises={setSelectedExercises}/>
                    </div>

                    <div className="form-actions">
                        <button type="submit" className="btn-primary" >
                            Create Routine
                        </button>
                        <button type="button" className="btn-outline" onClick = {() => navigate("/routines")}>
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default CreateRoutine;