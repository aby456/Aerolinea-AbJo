

import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/navbar/Navbar";
import AppRouter from "./routers/AppRouter";

const App: React.FC = () => {
  return (
    <div>
      <Navbar />
      <div className="container mt-3">
        <AppRouter/>
      </div>

      
    </div>
  );
}
export default App;
