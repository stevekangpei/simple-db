package simpledb.dbfile;

import simpledb.exception.DbException;
import simpledb.exception.TransactionAbortedException;
import simpledb.tuple.Tuple;

import java.util.*;

/**
 * DbFileIterator is the iterator interface that all SimpleDB Dbfile should
 * implement.
 */
public interface DbFileIterator{
    /**
     * Opens the iterator
     * @throws DbException when there are problems opening/accessing the database.
     */
    public void open()
        throws DbException, TransactionAbortedException;

    /** @return true if there are more tuples available, false if no more tuples or iterator isn't open. */
    public boolean hasNext()
        throws DbException, TransactionAbortedException;

    /**
     * Gets the next tuple from the operator (typically implementing by reading
     * from a child operator or an access method).
     *
     * @return The next tuple in the iterator.
     * @throws NoSuchElementException if there are no more tuples
     */
    public Tuple next()
        throws DbException, TransactionAbortedException, NoSuchElementException;

    /**
     * Resets the iterator to the start.
     * @throws DbException When rewind is unsupported.
     */
    public void rewind() throws DbException, TransactionAbortedException;

    /**
     * Closes the iterator.
     */
    public void close();
}
