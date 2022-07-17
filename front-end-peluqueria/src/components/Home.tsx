//import logo from '../logo.svg';

type AppProps = {
    title : string;
    description: string;
  }

export const Home = (props: AppProps) => {
    return (
        <div className="px-4 py-5 my-5 text-center">
          <img src= "https://c8.alamy.com/compes/2c3rtf9/vector-logo-peluqueria-peine-secador-de-pelo-y-tijeras-2c3rtf9.jpg" className="d-block mx-auto mb-4" height="400" alt="logo"/>
          <h1 className='display-5 fw-bold'>{props.title}</h1>
          <div className='col-lg-6 mx-auto'>
            <p className='lead mb-4'>
              {props.description}
            </p>
          </div>
        </div>
      );
}