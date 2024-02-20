// ** MUI Imports

import { ThemeProvider, createTheme } from "@mui/material";
import "./Admin.css";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const darkTheme1 = createTheme({
  palette: {
    mode: 'dark',
    primary: {
      main: '#312d4b',
    },
    secondary: {
      main: '#f48fb1',
    },
  },
});



// bg-[#28243d]
const Dashboard = () => {
  const {auth}=useSelector(store=>store);
  const navigate=useNavigate()


 
  return (
    <div className="adminContainer ">
    </div>
  );
};

export default Dashboard;
