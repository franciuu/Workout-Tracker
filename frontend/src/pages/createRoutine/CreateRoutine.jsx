import "./CreateRoutine.css"
import ExercisesList from "../../components/exercisesList/ExercisesList.jsx"
import { useNavigate } from "react-router-dom";

const CreateRoutine = () => {
    const navigate = useNavigate();

    return (
        <div className="create-routine-page">
            <div className="create-routine-container">
                <div className="create-routine-header">
                    <button className="back-button" onClick={() => navigate("/routines")}>
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
                        >
                            <path d="m12 19-7-7 7-7" />
                            <path d="M19 12H5" />
                        </svg>
                        Back to Routines
                    </button>
                    <h1 className="create-routine-title">Create Routine</h1>
                    <p className="create-routine-subtitle">Build a custom workout routine</p>
                </div>

                <form className="create-routine-form">
                    <div className="form-card">
                        <div className="form-card-body">
                            <div className="form-group">
                                <label htmlFor="routine-name" className="form-label">Routine Name</label>
                                <input 
                                    id="routine-name" 
                                    name="routine-name" 
                                    type="text" 
                                    className="form-input"
                                    placeholder="e.g., Upper Body Strength"
                                />
                            </div>
                        </div>
                    </div>

                    <div className="exercises-section">
                        <ExercisesList/>
                    </div>

                    <div className="form-actions">
                        <button type="submit" className="btn-primary">
                            Create Routine
                        </button>
                        <button type="button" className="btn-outline">
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default CreateRoutine;