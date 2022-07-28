import React, { memo, useContext } from "react";
import PaginationContext from "../contexts/PaginationContext";

const Pagination = () => {
  const itemPerPage = [5, 10, 15, 20];
    const {setItem, page, setPage, total}:any= useContext(PaginationContext);

    const handleChangeItemPage = (event:any) => {
        setItem(event.target.value);
    }
    const handleNextPage = () => {
        setPage(page + 1);
        
    }
    const handlePrevPage = () => {
        setPage(page - 1);
    }
  return (
    <div>
      <nav aria-label="Page navigation example">
        <ul className="pagination">
          <li className="page-item">
            {
                page > 0 ? <button className="page-link" onClick={handlePrevPage}>Previous</button>:<></>
            }
          </li>

          <li className="page-item">
            <select className="page-link" onChange={handleChangeItemPage}>
              {
                itemPerPage.map((item, index) => (
                    <option key={index}>{item}</option>
                ))
              }
            </select>
          </li>
          <li className="page-item">
            {
                page < total ? <button className="page-link" onClick={handleNextPage}>Next</button>:<></>
            }
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default memo(Pagination);
