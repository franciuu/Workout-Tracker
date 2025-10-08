import "./mainNavBar.css"

const MainNavBar = () => {
    return (
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-2">
            <a class="navbar-brand" href="#">
                <img src="/assets/logo.png" alt="Logo" height="45"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse p-2" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/dashboard">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/exercises">Exercises</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/routines">Routines</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/history">History</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/badges">Badges</a>
                    </li>
                </ul>
            </div>
        </nav>
    );
};
export default MainNavBar;