import IUser from "../models/User";
import jwt_decode from 'jwt-decode';
const getInfoUser = (): IUser| null => {
  
  if (localStorage.getItem("token")) {
    const token: string = localStorage.getItem("token")!;
    const decoded: any = jwt_decode(token);
    const authorities = decoded.authorities;
    const user: IUser = {
      user: decoded.sub,
      rols: JSON.parse(authorities),
    };
    return user;

  }
  return null;
};


export default getInfoUser;
