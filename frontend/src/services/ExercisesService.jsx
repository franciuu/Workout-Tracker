import axios from "axios"

export const fetchExercises = async (filters) => {
    return axios.post('http://localhost:8080/exercises', filters);
};