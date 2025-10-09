import "./SearchBar.css";

const SearchBar = () => {
  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="search-container">
            <input type="text" className="form-control search-input" placeholder="Search..."/>
            <i className="bi bi-search search-icon"></i>
          </div>
        </div>
      </div>
    </div>
  );
}
export default SearchBar;