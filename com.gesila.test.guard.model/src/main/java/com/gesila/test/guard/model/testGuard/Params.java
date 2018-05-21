/**
 */
package com.gesila.test.guard.model.testGuard;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Params</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gesila.test.guard.model.testGuard.Params#getParam <em>Param</em>}</li>
 * </ul>
 *
 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getParams()
 * @model
 * @generated
 */
public interface Params extends EObject {
	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference list.
	 * The list contents are of type {@link com.gesila.test.guard.model.testGuard.Param}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference list.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getParams_Param()
	 * @model containment="true"
	 * @generated
	 */
	EList<Param> getParam();

} // Params
