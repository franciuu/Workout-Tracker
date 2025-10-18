import "./RoutineCard.css";

const RoutineCard = () => {
    return (
        <div className="routine-card">
            <div className="routine-card-header">
                <h5 className="routine-title">Mock</h5>
                <p className="routine-description">2 exercises</p>
            </div>
            <div className="routine-card-body">
                <button className="routine-btn-primary">
                    <i class="bi bi-play-circle"></i>
                    Start Workout
                </button>
                <div className="routine-actions">
                    <button className="routine-btn-outline routine-btn-edit">
                        <i class="bi bi-pen"></i>
                        Edit
                    </button>
                    <button className="routine-btn-outline routine-btn-delete">
                        <i className="bi bi-trash"></i>
                    </button>
                </div>
            </div>
        </div>
    );
};

export default RoutineCard;