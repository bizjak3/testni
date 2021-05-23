describe("Prijava registriranega uporanika", function () {
    it('Visit login page and login', function () {
        cy.visit('http://localhost:4200/signup')

        cy.url()
            .should('include', '/signup')

        cy.get('.name')
            .type('Marjetka')
            .should('have.value', 'Marjetka')

        cy.get('.lastname')
            .type('Novak')
            .should('have.value', 'Novak')

        cy.get('.username')
            .type('marjetkanovak')
            .should('have.value', 'marjetkanovak')

        cy.get('.email')
            .type('metkanovak@gmail.com')
            .should('have.value', 'metkanovak@gmail.com')

        cy.get('.password1')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('.password2')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('[type="radio"]').check('lastnik')

        // cy.get('.btn-primary')
        //     .click()
        // cy.wait(10000)

        // cy.get('h1').contains('PRIJAVA')
        //
        //
        //
        // cy.visit('http://localhost:4200/login')
        //
        // cy.url()
        //     .should('include', '/login')
        //
        // cy.get('.email')
        //     .type('marjetkanovak')
        //     .should('have.value', 'marjetkanovak')
        //
        // cy.get('.password')
        //     .type('care')
        //     .should('have.value', 'care')
        //
        // cy.get('.btn-primary')
        //     .click()
        // cy.wait(500)
        //
        // cy.url()
        //     .should('include', '/pregled_storitev')
        // cy.contains('Možne storitve')
    });
})
