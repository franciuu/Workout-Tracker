import axios from "axios";

export const fetchRoutines = async () => {
    return axios.get('http://localhost:8080/routines');
}

export const createRoutine = async (routineData) => {
    return axios.post('http://localhost:8080/routines', routineData);
}