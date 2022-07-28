

export const Home = () => {
  const title = "Peluqueria AbJo";
  const description = "Aplicación web para la reservacion en una peluqueria";
    return (
      <div className="px-4 py-5 my-5 text-center">
      <img src= "https://c8.alamy.com/compes/2c3rtf9/vector-logo-peluqueria-peine-secador-de-pelo-y-tijeras-2c3rtf9.jpg" className="d-block mx-auto mb-4" height="400" alt="logo"/>
      <h1 className='display-5 fw-bold'>{title}</h1>
      <div className='col-lg-6 mx-auto'>
        <p className='lead mb-4'>
          {description}
        </p>
      </div>
    </div>
      );
}