import "./ExerciseCard.css";

const ExerciseCard = ({exercise}) => {
  return (
    <div className="card exercise-card text-light">
      <div className="exercise-image-wrapper">
        <img className="exercise-image" src={exercise.videoUrl || "/placeholder.svg"} alt={exercise.name} />
      </div>
      
      <div className="card-body exercise-card-body">
        <div className="d-flex align-items-start justify-content-between mb-2">
          <h5 className="card-title exercise-title mb-0">{exercise.name}</h5>
        </div>
        
        <p className="card-text exercise-desc mb-3">
          {exercise.description}
        </p>

        <ul className="list-inline">
          {exercise.categoriesNames.map((catName, index) => (
          <li key={index} className="list-inline-item rounded-pill exercise-pill">{catName}</li>
          ))}
        </ul>
        
      </div>
    </div>
  );
};

export default ExerciseCard;