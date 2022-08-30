import IUser from "../models/User";
import jwt_decode from 'jwt-decode';
const getInfoUser = (): IUser => {
  const token:any = localStorage.getItem("token");
  const decoded: any = jwt_decode(token);
  const authorities = decoded.authorities;
  const user: IUser = {
    user: decoded.sub,
    rols: JSON.parse(authorities),
  };

  return user;
};

export default getInfoUser;
