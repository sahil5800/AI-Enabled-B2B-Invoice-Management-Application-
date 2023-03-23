import * as React from 'react';
import "../App.css";
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { Grid } from '@mui/material';
import axios from 'axios';




export default function FormDialog() {
  
  const [open, setOpen] = React.useState(false);

  const [code, setCode] = React.useState('');
  const [custno, setCustno] = React.useState();
  const [cdate, setCdate] = React.useState('')
  const [byear, setByear] = React.useState('')
  const [did, setDid] = React.useState('')
  const [pdate, setPdate] = React.useState('')
  const [dcreatedate, setDcreatedate] =React.useState('')
  const [duedate, setDuedate] = React.useState('')
  const [icurrency, setIcurrency] = React.useState('')
  const [postid, setPostid] = React.useState()
  const [dtype, setDtype] = React.useState('')
  const [taamount, setTaamount] = React.useState()
  const [basecreated, setBasecreated] = React.useState('')
  const [custpayterm, setCustpayterm] = React.useState('')
  const [invoiceid, setInvoiceid] = React.useState()
  
  


  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const addsubmit = () => {
   let val="business_code=" + code + "&cust_number=" + custno + "&clear_date=" + cdate + "&buisness_year=" + byear + "&doc_id=" + did + "&posting_date=" + pdate + "&document_create_date=" + dcreatedate +
   "&due_in_date=" + duedate + "&invoice_currency=" + icurrency + "&document_type=" + dtype + "&posting_id=" + postid + "&total_open_amount=" +taamount + "&baseline_create_date=" + basecreated + "&cust_payment_terms=" + custpayterm
   + "&invoice_id=" + invoiceid

    axios.get("http://localhost:8081/hrc_final/newinvoice?"+ val).then(()=>{
      handleClose();
  })

  };

  return (
    <div>
      <button className='button crud' onClick={handleClickOpen}>ADD</button>
      <Dialog open={open} onClose={handleClose} fullWidth maxWidth="sm">
        <div  style={{backgroundColor: '#1b2b45'}}><DialogTitle>ADD</DialogTitle></div>
        <DialogContent  style={{backgroundColor: '#1b2b45'}}>
        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}     style={{backgroundColor: '#1b2b45'}}>
            <Grid item xs={3}>
                <input  type="text" placeholder="Business Code"  onChange={event => setCode(event.target.value)}  />
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Customer Number" onChange={event => setCustno(event.target.value)}></input>
                </Grid>
            <Grid item xs={3}>
            <input  type="date" placeholder="Clear Date" onChange={event => setCdate(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Business year" onChange={event => setByear(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Document ID" onChange={event => setDid(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="date" placeholder="Posting Date" onChange={event => setPdate(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="date" placeholder="Document Create Date" onChange={event => setDcreatedate(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="date" placeholder="Due Date" onChange={event => setDuedate(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Invoice Currency" onChange={event => setIcurrency(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Posting ID" onChange={event => setPostid(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Document Type" onChange={event => setDtype(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Total Open Amount" onChange={event => setTaamount(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="date" placeholder="Baseline Create Date" onChange={event => setBasecreated(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Customer Payment Terms" onChange={event => setCustpayterm(event.target.value)}></input>
            </Grid>
            <Grid item xs={3}>
            <input  type="text" placeholder="Inovice ID" onChange={event => setInvoiceid(event.target.value)}></input>
            </Grid>
        </Grid>
          
        </DialogContent>
        <DialogActions  style={{backgroundColor: '#1b2b45'}}>
        <Grid container rowSpacing={5} columnSpacing={{ xs: 1, sm: 2, md: 3}}>
        <Grid item xs={6}>
        <button className='button action' onClick={addsubmit}>ADD</button>
        </Grid>
        <Grid item xs={6}>
        <button className='button action' onClick={handleClose}>CANCEL</button>
        </Grid>
        </Grid>
        </DialogActions>
      </Dialog>
    </div>
  );
}