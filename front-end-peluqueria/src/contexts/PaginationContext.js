import React, { useState } from "react";

const Context = React.createContext({});

export const PaginationContextProvider = ({children}) => {
    const [item, setItem] = useState(5);
    const [page, setPage] = useState(0);
    const [total, setTotal] = useState(1);

    return (
        <Context.Provider value={{ item, setItem, page, setPage, total, setTotal }}>
            {children}
        </Context.Provider>
    );
};

export default Context;